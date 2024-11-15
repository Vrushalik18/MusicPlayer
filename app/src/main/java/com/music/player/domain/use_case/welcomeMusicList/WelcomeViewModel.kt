package com.music.player.domain.use_case.welcomeMusicList

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.music.player.domain.use_case.welcomeMusicList.model.PlayListModel
import com.music.player.data.remote.PlayListRoomdatabase
import com.music.player.data.repository.MainRepository

class WelcomeViewModel(application: Application):AndroidViewModel(application) {
    private lateinit var repository: MainRepository

    init {
        val database=PlayListRoomdatabase.getInstance(application.applicationContext)
        val dao=database.PlayListMusic()
        repository= MainRepository(dao)

    }

    fun insertPlayList(savingListModel: PlayListModel){
        repository.insertPlayList(savingListModel)
    }
    fun deletePlayList(savingListModel: PlayListModel){
        repository.deletePlayList(savingListModel)
    }

    fun getfavourites(): LiveData<List<PlayListModel>> {
        return repository.getPlayList()
    }



}