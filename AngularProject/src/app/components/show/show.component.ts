import { Component, OnInit } from '@angular/core';
import { TestServiceService } from 'src/app/shared/test-service.service';
import { FormArray, FormGroup, FormControl } from '@angular/forms';

@Component({
  selector: 'app-show',
  templateUrl: './show.component.html',
  styleUrls: ['./show.component.css']
})
export class ShowComponent implements OnInit {

  constructor(private tss: TestServiceService) { }

  createNewGroup(t){
    const questions = new FormGroup({
      ques: new FormControl(t.ques),
      ans: new FormControl(t.ans),
      correctAns: new FormControl(t.correctAns)
    })
    return questions
  }
  test = []
  completedQuestions = new FormArray([])
  loadTests() {
    this.tss.loadTestData('/userTest.json').subscribe(resp => {
      const tests = []
      for (let t in resp) {
        tests.push(resp[t])
      }
      this.test = tests[0]
      this.test.forEach(t => {
        const questions = this.createNewGroup(t)
        this.completedQuestions.push(questions)
      })
    });
  }
  ngOnInit(): void {
    this.loadTests()
  }

}
