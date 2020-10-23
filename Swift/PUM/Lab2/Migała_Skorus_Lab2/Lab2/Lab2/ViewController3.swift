//
//  ViewController3.swift
//  Lab2
//
//  Created by Student on 23.10.2020.
//  Copyright © 2020 pl.polsl. All rights reserved.
//

import UIKit

protocol myDelegateProtocol:class {
    func myDelegateFunction(slider: Float)
}

class ViewController3: UIViewController {
    
    var mouth:Float = 0.5

    @IBOutlet weak var sliderMouth: UISlider!
    weak var delegate: myDelegateProtocol?
    
    @IBAction func exit(_ sender: Any) {
        let sliderVal = sliderMouth.value
        delegate?.myDelegateFunction(slider: sliderVal)
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        sliderMouth.value = self.mouth
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
