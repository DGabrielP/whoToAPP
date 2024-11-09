package com.who.to.whoToAPP.controller

import com.who.to.whoToAPP.model.EventModel
import com.who.to.whoToAPP.response.ErrorResponse
import com.who.to.whoToAPP.response.FailedResponse
import com.who.to.whoToAPP.response.SuccessResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/event")
class EventController {


    @GetMapping("/failed")
    fun getModel(@RequestBody model: EventModel): ResponseEntity<*> {

        return ResponseEntity(
            FailedResponse().apply{
                status = "failed"
                data = "invalid name"
            },
            HttpStatus.FAILED_DEPENDENCY
        )
    }

    @GetMapping("/{id}")
    fun getEvent(@PathVariable id: Long): ResponseEntity<*> {
        return if (id == 1L) {
            ResponseEntity(SuccessResponse("success", EventModel(1L, "Partido de futbol", "2024-11-22", "22:00", "busco personas que quieran jugar futbol por las noches", 22)), HttpStatus.OK)
        } else {
            ResponseEntity(ErrorResponse("error", "Event not found"), HttpStatus.NOT_FOUND)
        }
    }

    @PostMapping
    fun createEvent(@RequestBody model: EventModel): ResponseEntity<*> {
        return if (model.title.isBlank()) {
            ResponseEntity(ErrorResponse("error", "Invalid data: title cannot be blank"), HttpStatus.BAD_REQUEST)
        } else {
            ResponseEntity(SuccessResponse("success", model), HttpStatus.CREATED)
        }
    }

    @PutMapping("/{id}")
    fun updateEvent(@PathVariable id: Long, @RequestBody model: EventModel): ResponseEntity<*> {
        return if (id == 1L) {
            ResponseEntity(SuccessResponse("success", model), HttpStatus.OK)
        } else {
            ResponseEntity(ErrorResponse("error", "Event not found for update"), HttpStatus.NOT_FOUND)
        }
    }

    @DeleteMapping("/{id}")
    fun deleteEvent(@PathVariable id: Long): ResponseEntity<*> {
        return if (id == 1L) {
            ResponseEntity(SuccessResponse("success", "Event deleted successfully"), HttpStatus.OK)
        } else {
            ResponseEntity(ErrorResponse("error", "Event not found for deletion"), HttpStatus.NOT_FOUND)
        }
    }
}




