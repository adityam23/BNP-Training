import { Component, OnInit } from '@angular/core';
import { TestServiceService } from 'src/app/shared/test-service.service';
import { FormArray, FormGroup, FormControl, FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-test',
  templateUrl: './test.component.html',
  styleUrls: ['./test.component.css']
})
export class TestComponent implements OnInit {

  constructor(private tss: TestServiceService, private fb: FormBuilder) {
  }
 
  onSubmit() {
    console.log( this.testQuestions.value )
    this.tss.addTestToDb(this.testQuestions.value, '/userTest.json')
    alert('Submitted test')
  }

  createNewGroup(t){
    const questions = new FormGroup({
      ques: new FormControl(t.ques),
      ans: new FormControl(t.ans),
      correctAns: new FormControl(t.correctAns)
    })
    return questions
  }
  test = []
  testQuestions = new FormArray([])

  loadTests() {
    this.tss.loadTestData('/testData.json').subscribe(resp => {
      const tests = []
      for (let t in resp) {
        tests.push(resp[t])
      }
      this.test = tests[0]
      this.test.forEach(t => {
        const questions = this.createNewGroup(t)
        this.testQuestions.push(questions)
      })
    });
  }
  ngOnInit(): void {
    this.loadTests()
  }
}
