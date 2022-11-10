package com.example.animcare.Classes

class Section {
    var id: String = "null"
    var name: String? = "null"
    var paragraphs: ArrayList<Paragraph> = arrayListOf()

    constructor()
    constructor(id: String, name: String, paragraphs: ArrayList<Paragraph>){
        this.id = id
        this.name = name
        this.paragraphs = paragraphs
    }

}