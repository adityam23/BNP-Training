
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TestServiceService {

  addTestToDb(testData,dataStore){
    let url = { firebase-link }
    url += dataStore
    console.log("posting to : "+url)
    this.http.post(url,testData).subscribe(response => {
      console.log(response)
    })
  }

  loadTestData(dataStore):Observable<any>{
    let url = { firebase-link }
    url += dataStore
    console.log('getting from : '+url)
    return this.http.get<any[]>(url)
  }
  constructor(private http:HttpClient) { }
}
