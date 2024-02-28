import { Component } from '@angular/core';
import { FormBuilder, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { MatSnackBar } from '@angular/material/snack-bar';
import { MatCardModule } from '@angular/material/card';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatChipsModule } from '@angular/material/chips';
import { MatIconModule } from '@angular/material/icon';
import { CommonModule } from '@angular/common';
import { MatInputModule } from '@angular/material/input';
import { MaterialModule } from '../../MaterialModule';
import { PostService } from '../../service/post.service';
import { HttpClient, HttpClientModule } from '@angular/common/http';


@Component({
  selector: 'app-create-post',
  standalone: true,
  imports: [
    MatCardModule,
    ReactiveFormsModule,
    MatFormFieldModule,
    MatChipsModule,
    MatIconModule,
    CommonModule,
    FormsModule,
    MatInputModule,
    MaterialModule,
    HttpClientModule,
  ],
  templateUrl: './create-post.component.html',
  styleUrls: ['./create-post.component.scss'],
})


export class CreatePostComponent {
  
  postForm!: FormGroup;
  tags:string[] = [];

  constructor(private fb: FormBuilder,
    private router: Router,
    private snackBar: MatSnackBar,
    private postService: PostService){}

    createPostz(): void {
      // Implement the logic for creating a post
      console.log('Creating post...');
    }


createPost(){
  const data = this.postForm.value;
  data.tags = this.tags;

  this.postService.createNewPost(data).subscribe((response)=>{
    this.snackBar.open("Post Created Sucessfully..!", "OK");
    this.router.navigateByUrl("/");
  }, error=>{
    this.snackBar.open("Something went worng..!", "OK")
  }
  );
}

ngOnInit(){
  this.postForm = this.fb.group({
    title: [null, Validators.required],
    content: [null, [Validators.required, Validators.maxLength(5000)]],
    image: [null, Validators.required],
    author: [null, Validators.required]
  })
}


add(event:any){
  const value = (event.value || '').trim();
  if(value){
    this.tags.push(value);
  }
  event.chipInput!.clear();
}

remove(tag:any){
  const index = this.tags.indexOf(tag);
  
  if(index >= 0){
    this.tags.splice(index,1);
  }
}

}

