//
//  ViewController2.swift
//  Lab2
//
//  Created by Student on 23.10.2020.
//  Copyright © 2020 pl.polsl. All rights reserved.
//

import UIKit

class ViewController2: UIViewController {

    @IBOutlet weak var sliderR: UISlider!
    @IBOutlet weak var sliderB: UISlider!
    @IBOutlet weak var sliderG: UISlider!
    var tempR:Float = 0.5
    var tempG:Float = 0.5
    var tempB:Float = 0.5
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        sliderR.value = tempR
        sliderB.value = tempB
        sliderG.value = tempG

        // Do any additional setup after loading the view.
    }
    

    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destination.
        // Pass the selected object to the new view controller.
    }
    */

}
