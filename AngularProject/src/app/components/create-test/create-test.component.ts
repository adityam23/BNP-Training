import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms'
import { FormBuilder } from '@angular/forms';
import { FormArray } from '@angular/forms';
import { TestServiceService } from '../../shared/test-service.service'

@Component({
  selector: 'app-create-test',
  templateUrl: './create-test.component.html',
  styleUrls: ['./create-test.component.css'],
  // providers: [{provide: MatFormFieldControl, useExisting: MyQuestionInput}],
})

// class MyQuestion {
//   constructor(public ques, public correctAns){}
// }
// class MyQuestionInput implements MatFormFieldControl<MyQuestion>{
//   constructor(private tf)
// }
export class CreateTestComponent implements OnInit {

  constructor(private tf: FormBuilder, private tss:TestServiceService) { }

  ngOnInit(): void {
  }
  allQuestions = new FormArray([])



  addQuestion() {
    const question = new FormGroup({
      ques: new FormControl(''),
      ans: new FormControl(''),
      correctAns: new FormControl(''),
    })
    this.allQuestions.push(question)
  }

  onSubmit(){
    console.log(this.allQuestions.value)
    this.tss.addTestToDb(this.allQuestions.value,'/testData.json')
    alert('Added test to Db')
  }
}
