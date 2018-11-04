package com.epam;

import java.io.File;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.LinkPermission;
import java.util.ArrayList;
import java.util.zip.CRC32;
import java.util.zip.Checksum;

import com.beaglebuddy.mp3.MP3;

public class Main {

    public static void main(String[] args) throws IOException {

        ArrayList<File> array = new ArrayList<>();
        for(String a : args){
            File f = new File (a);
            arrayOfFiles(f, array);
        }
       for(File d : array){
            System.out.println(d.getName());
            MP3 mp3 = new MP3(d);
            System.out.println(mp3.getAlbum());
        }

        //создание html-страница с отсортированным списком исполнителей
        File file = new File("D://mp3.html");
        file.createNewFile();

        ArrayList<File> newArray = new ArrayList<>(array);

        FileWriter out = new FileWriter(file);

        out.write("<!DOCTYPE html><body><table><center>");

       for(File f : array){
            try {
                MP3 audio = new MP3(f);
                ArrayList<File> arrayOfAlbums = new ArrayList<>();
                for(File ar : newArray) {
                    MP3 artist = new MP3(ar);
                    if (audio.getBand() == artist.getBand()) {
                        arrayOfAlbums.add(ar);
                    }
                }

                if(arrayOfAlbums.contains(f)) {
                    out.write("<tr>");
                    out.write("<td>");
                    if (audio.getBand() == null) {
                        out.write("Unknown artist");
                    } else {
                        out.write(audio.getBand());
                    }
                    out.write("</td>");
                    out.write("</tr>");

                    for (File a : arrayOfAlbums) {
                        if (newArray.contains(a)) {
                            newArray.remove(a);
                        }
                    }

                    ArrayList<File> albums = new ArrayList<>(arrayOfAlbums);

                    for (File a : arrayOfAlbums) {
                        MP3 audio1 = new MP3(a);

                        ArrayList<File> arrayOfTracks = new ArrayList<>();

                        for (File b : albums) {
                            MP3 audio2 = new MP3(b);
                            if (audio1.getAlbum() == audio2.getAlbum()) {
                                arrayOfTracks.add(b);
                            }
                        }

                        for (File n : arrayOfTracks) {
                            if (albums.contains(n)) {
                                albums.remove(n);
                            }
                        }

                        if (arrayOfTracks.contains(a)) {
                            out.write("<tr style =\"text-indent: 25px\">");
                            out.write("<td>");
                            if (audio1.getAlbum() == null) {
                                out.write("Unknown album");
                            } else {
                                out.write(audio1.getAlbum());
                            }
                            out.write("</td>");
                            out.write("</tr>");

                            for (File t : arrayOfTracks) {
                                MP3 track = new MP3(t);
                                out.write("<tr>");
                                out.write("<td style =\"text-indent: 50px\">");
                                if (track.getTitle() == null) {
                                    out.write("Unknown track");
                                } else {
                                    out.write(track.getTitle());
                                }
                                out.write("</td>");
                                out.write("<td style =\"text-indent: 10px\">");
                                out.write(String.valueOf(track.getAudioDuration()));
                                out.write("</td>");
                                out.write("<td style =\"text-indent: 10px\">");
                                out.write(t.getPath());
                                out.write("</td>");
                                out.write("</tr>");
                            }
                            arrayOfTracks.clear();

                        }
                    }
                }
            }catch (NullPointerException e){}
       }

        out.write("</center></table></body></html>");
        out.flush();
        out.close();


        //отсортированные по констрольной сумме дубликаты
        File sortByCheckSum = new File("D://byCheckSum");

        FileWriter out1 = new FileWriter(sortByCheckSum);
        file.createNewFile();

        out1.write("<!DOCTYPE html><body><table><center>");

        ArrayList<File> copyArray = new ArrayList<>(array);
        for(File a : array){
            ArrayList<File> dublic = new ArrayList<>();
            Checksum checksum1 = new CRC32();
            //long checksum =

           // MP3 audio = new MP3(a);
            for(File b : copyArray){
                MP3 audio1 = new MP3(b);
                //if(audio.get)
            }
        }


    }

    //сортировка mp3 от остальных форматов
    private static ArrayList<File> arrayOfFiles (File dir, ArrayList<File> array){

        FilenameFilter filter = new MyFileFilter();
        for(File f : dir.listFiles()){
            if(f.isDirectory()){
                arrayOfFiles(f, array);
            }
        }
        File[] files = dir.listFiles(filter);
        for(File f : files){
            array.add(f);
        }
        return array;
    }

}
