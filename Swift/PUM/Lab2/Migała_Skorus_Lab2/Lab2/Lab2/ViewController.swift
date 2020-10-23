//
//  ViewController.swift
//  Lab2
//
//  Created by Student on 23.10.2020.
//  Copyright © 2020 pl.polsl. All rights reserved.
//

import UIKit

class ViewController: UIViewController, myDelegateProtocol {
    
    
    @IBOutlet weak var f1: FaceView!
    var r:Float = 0.5
    var g:Float = 0.5
    var b:Float = 0.5
    var mouth:Float = 0.5
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        if segue.identifier=="modal1" {
            let destination = segue.destination as! ViewController2
            destination.tempR = self.r;
            destination.tempG = self.g;
            destination.tempB = self.b;
            
        } else if segue.identifier=="modal2" {
            let destination = segue.destination as! ViewController3
            destination.delegate = self
            destination.mouth = self.mouth
        }
    }
    
    @IBAction func exit(_ segue: UIStoryboardSegue) {
        
        let source = segue.source as! ViewController2
        self.r = source.sliderR.value
        self.g = source.sliderG.value
        self.b = source.sliderB.value
        let r = CGFloat(self.r)
        let g = CGFloat(self.g)
        let b = CGFloat(self.b)
        changeColors(r: r, g: g, b: b)
        
    }
    
    func changeColors(r:CGFloat,g:CGFloat,b:CGFloat) {
        f1.r = r
        f1.b = b
        f1.g = g
        f1.setNeedsDisplay()
        
    }
    
    func convetToMouthVal(sliderVal:Float) -> Float{
        let min:Float = 0
        let max:Float = 100
        let difference = max - min
        return sliderVal * difference - min
    }

    func myDelegateFunction(slider: Float) {
        self.mouth = slider;
        f1.mouth = CGFloat(convetToMouthVal(sliderVal: self.mouth))
        f1.setNeedsDisplay()
        dismiss(animated: true, completion: nil)
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        f1.setNeedsDisplay()
        // Do any additional setup after loading the view, typically from a nib.
    }


}

