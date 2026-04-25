import { Component, ViewChild } from '@angular/core';
import { FormsModule, NgForm } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { NoteService } from '../service/note.service';

@Component({
  selector: 'app-create-note',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './create-note.html',
  styleUrls: ['./create-note.scss'],
})
export class CreateNote {
  title: string = '';
  description: string = '';

  @ViewChild('noteForm') noteForm!: NgForm;

  constructor(private noteService: NoteService) {}

  saveNote() {
    const noteData = {
      title: this.title,
      description: this.description,
    };

    this.noteService.createNote(noteData).subscribe({
      next: (res: any) => {
        if (res.statusCode < 400) {
          this.noteForm.resetForm();

          window.alert(res.message);
        } else {
          window.alert(res.message);
        }
      },
      error: (err) => {
        console.error('Server error', err);
      },
    });
  }
}
