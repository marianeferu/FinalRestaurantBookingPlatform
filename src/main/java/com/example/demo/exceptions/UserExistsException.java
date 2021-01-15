package com.example.demo.exceptions;

public class UserExistsException extends RuntimeException {

    //public UserExistsException(String username){
     //   super(String.format("Username already in use", username));
   // }

    public UserExistsException() {
        super(String.format("Username already in use"));
    }


//}
}
