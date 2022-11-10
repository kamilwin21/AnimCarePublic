package com.example.animcare.Classes

class Paragraph {
    var position: String = "null"
    var viewType: String = "null" //text or image
    var imageLocalization: ImageLocalization = ImageLocalization()
    var text: String = "null"


    constructor()
    constructor(position: String,
                viewType: String,
                imageLocalization: ImageLocalization,
                text: String
                ){
        this.position = position
        this.viewType = viewType
        this.imageLocalization = imageLocalization
        this.text = text

    }
}