package com.notesjc.di

import android.app.Application
import androidx.room.Room
import com.notesjc.data.note.data_source.NoteDatabase
import com.notesjc.data.note.repository.NoteRepository
import com.notesjc.data.note.repository.NoteRepositoryImpl
import com.notesjc.data.note.use_case.AddNoteUseCase
import com.notesjc.data.note.use_case.DeleteNoteUseCase
import com.notesjc.data.note.use_case.GetNoteUseCase
import com.notesjc.data.note.use_case.GetNotesUseCase
import com.notesjc.data.note.use_case.NotesUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNoteDatabase(app: Application): NoteDatabase {
        return Room.databaseBuilder(
            app,
            NoteDatabase::class.java,
            NoteDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideNoteRepository(db: NoteDatabase): NoteRepository {
        return NoteRepositoryImpl(db.noteDao)
    }

    @Provides
    @Singleton
    fun provideNoteUseCases(repository: NoteRepository): NotesUseCases {
        return NotesUseCases(
            getNotes = GetNotesUseCase(repository),
            deleteNote = DeleteNoteUseCase(repository),
            addNote = AddNoteUseCase(repository),
            getNote = GetNoteUseCase(repository)
        )
    }
}