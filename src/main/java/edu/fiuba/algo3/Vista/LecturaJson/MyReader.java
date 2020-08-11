package edu.fiuba.algo3.Vista.LecturaJson;

import com.google.gson.*;
import com.google.gson.stream.JsonReader;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

public class MyReader{


    public static void Main(String[] args){
        try {
            Reader myReader = Files.newBufferedReader(Paths.get("preguntas.json"));
            Gson gson = new Gson();








        } catch (IOException e) {
            e.printStackTrace();
        }


    }




}








