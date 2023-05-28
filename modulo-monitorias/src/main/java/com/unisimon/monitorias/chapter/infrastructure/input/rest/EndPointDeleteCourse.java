package com.unisimon.monitorias.chapter.infrastructure.input.rest;

import com.unisimon.monitorias.chapter.application.handler.ICourseHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/course")
@RequiredArgsConstructor
public class EndPointDeleteCourse {

    private final ICourseHandler courseHandler;

    @Operation(summary = "Delete a course by its Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Course deleted", content = @Content),
            @ApiResponse(responseCode = "400", description = "Course not found", content = @Content)
    })
    @DeleteMapping("/{courseId}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long courseId){
        courseHandler.deleteCourse(courseId);
        return ResponseEntity.noContent().build();
    }
}
