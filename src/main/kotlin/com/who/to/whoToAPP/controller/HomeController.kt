package com.who.to.whoToAPP.controller

import com.who.to.whoToAPP.model.UserModel
import com.who.to.whoToAPP.response.ErrorResponse
import com.who.to.whoToAPP.response.FailedResponse
import com.who.to.whoToAPP.response.SuccessResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/home")
class HomeController {

    @GetMapping()
    fun home(@RequestBody model: UserModel): ResponseEntity<*> {

        return ResponseEntity(
            SuccessResponse().apply{
            status = "success"
            data = model
        },
            HttpStatus.CREATED
        )
    }

    @GetMapping("/failed")
    fun getModel(@RequestBody model: UserModel): ResponseEntity<*> {

        return ResponseEntity(
            FailedResponse().apply{
            status = "failed"
            data = "invalid name"
        },
            HttpStatus.FAILED_DEPENDENCY
        )
    }

    @GetMapping("/error")
    fun errorModel(@RequestBody model: UserModel): ResponseEntity<*> {

        return ResponseEntity(
            ErrorResponse().apply{
            status = "error"
            message = "Unable to communicate with database"
        },
            HttpStatus.BAD_REQUEST
            )
    }

}