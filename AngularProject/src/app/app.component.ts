import { Component } from '@angular/core';
import { ThemePalette } from '@angular/material/core';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent {
  links = [
    { label: 'Add Questions', path: 'addQ' },
    { label: 'Test', path: 'test' },
    { label: 'Check/Show Answers', path: 'show' }
  ];
  activeLink = this.links[0];
  background: ThemePalette = "primary";
  title = 'phase4project';
}
