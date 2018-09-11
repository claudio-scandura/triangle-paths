# SuprNation coding test - Minimal Triangle Path

This scala project implements a solution to the problem of finding the minimal path in a triangle as explained in [exercise.pdf](exercise.pdf).


## Build, test and run
The project can be build and tested by running
 
        sbt test it:test
        
The application can be launched by running

        sbt run
        
it will then expect a triangle to be input and terminated by `Ctrl+D` 

        [info] Running com.suprnation.MinimalPathApp
        1
        2 3
        (Ctrl+D)

Alternatively, text files can be piped to the app. For instance, the [sample file](big_triangle.txt) in this repo can be passed by running the following

        cat big_triangle.txt | sbt run