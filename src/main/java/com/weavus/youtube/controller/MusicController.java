package com.weavus.youtube.controller;

import com.weavus.youtube.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class MusicController {

    private final MusicService musicService;

    @Autowired
    public MusicController(MusicService musicService) {
        this.musicService = musicService;
    }

    @GetMapping("/test")
    public String test() {

        return "index";
    }

    @PostMapping("/api/addToPlaylist")
    public ResponseEntity<String> addToPlaylist(@RequestBody String selectedSong) {
        boolean success = musicService.addToPlaylist(selectedSong);
        if (success) {
            return ResponseEntity.ok("Song added to playlist successfully!");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add song to playlist");
        }
    }
}
