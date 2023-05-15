package br.edu.ufersa.blockbuster.api.restControllers;

import br.edu.ufersa.blockbuster.libs.UploadImage;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/images")
public class UploadImageController {

    @PostMapping("/upload")
    public ResponseEntity<String> create(@RequestParam("file")MultipartFile file) {
        if (UploadImage.makeUploadImage(file)) {
            String path = "http://localhost:8080/api/images/" + file.getOriginalFilename();
            return new ResponseEntity<>(path, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/{image}")
    public ResponseEntity<Resource> getImages(@PathVariable String image) throws IOException {
        Resource resource = new ClassPathResource("/uploads/"+image);

        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG)
                .contentType(MediaType.IMAGE_PNG)
                .contentLength(resource.contentLength())
                .body(resource);
    }
}
