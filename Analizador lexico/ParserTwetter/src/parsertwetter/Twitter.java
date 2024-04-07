/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parsertwetter;

import java.util.ArrayList;

/**
 *
 * @author Saki
 */
public class Twitter {

    public String getRaw() {
        return raw;
    }

    public void setRaw(String raw) {
        this.raw = raw;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public ArrayList<String> getHashTag() {
        return hashTag;
    }

    public void setHashTag(ArrayList<String> hashTag) {
        this.hashTag = hashTag;
    }

    public ArrayList<String> getEmojis() {
        return emojis;
    }

    public void setEmojis(ArrayList<String> emojis) {
        this.emojis = emojis;
    }

    public ArrayList<String> getMension() {
        return mension;
    }

    public void setMension(ArrayList<String> mension) {
        this.mension = mension;
    }

    public ArrayList<String> getEnlaces() {
        return enlaces;
    }

    public void setEnlaces(ArrayList<String> enlaces) {
        this.enlaces = enlaces;
    }

    public String raw;
    public String text;
    public ArrayList<String> hashTag;
    public ArrayList<String> emojis;
    public ArrayList<String> mension;
    public ArrayList<String> enlaces;

    
    
   
}
