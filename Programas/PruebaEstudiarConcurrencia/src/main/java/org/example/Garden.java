package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Garden extends Thread{

    int id;
    Town town;
    int contadorParques = 0;

    @Override
    public void run() {
        System.out.println("Garden " + id + " is running");
        while(true){

        }
    }
}
