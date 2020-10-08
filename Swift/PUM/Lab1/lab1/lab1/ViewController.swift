//
//  ViewController.swift
//  lab1
//
//  Created by Student on 06/10/2020.
//  Copyright © 2020 Student. All rights reserved.
//

import UIKit

class ViewController: UIViewController {
    
    @IBOutlet weak var slider: UISlider!
    
    @IBOutlet weak var points: UILabel!
    
    @IBOutlet weak var roundsPlayed: UILabel!
    
    @IBOutlet weak var GuessingNumber: UILabel!
    
    
    func setGuessingNumber() {
        let randomNumb = randomNumber()
        GuessingNumber.text = String(randomNumb)
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        resetGame()
    }
    
    func countPoints()->Int {
        let guessNumber:String = GuessingNumber.text ?? "0"
        let guessNumberConverted:Int = Int(guessNumber)!
        let sliderValue:Float = slider.value
        let sliderValueConverted:Int = Int(sliderValue)
        
        let point = guessNumberConverted > sliderValueConverted ?  guessNumberConverted - sliderValueConverted : sliderValueConverted - guessNumberConverted
        let result = 100 - point
        return result
    }
    
    func randomNumber()->Int {
        let numb = Int.random(in: 1...100)
        return numb
    }
    
    func resetGame() {
        setGuessingNumber()
        points.text = "0"
        roundsPlayed.text = "0"
        slider.value = 50.0
        
    }
    
    func nextRound(alert: UIAlertAction!) {
        
        let rounds:String = roundsPlayed.text!
        let played:Int = Int(rounds)!
        let playedIncremented = played + 1
        roundsPlayed.text = String(playedIncremented)
        if playedIncremented > 10 {
            resetGame()
        }
        setGuessingNumber()
        
    }
    
    @IBAction func handleResetClick(_ sender: UIButton) {
        resetGame()
    }
    
    @IBAction func handleCheckClick(_ sender: UIButton) {
        let countedPoints = countPoints()
        let currentStringPoints = points.text!
        let currentPoints = Int(currentStringPoints)!
        let resultPoints = currentPoints + countedPoints
        
        points.text = String(resultPoints)
        let rounds:String = roundsPlayed.text!
        let played:Int = Int(rounds)!
        
        let alert = UIAlertController(title: "Wynik", message: played == 10 ? "Zdobyłeś w sumie: \(String(resultPoints)) punktów" : String(countedPoints), preferredStyle: .alert)
        let action = UIAlertAction(title: played == 10 ? "Nowa Gra" : "Graj Dalej", style: .default, handler: nextRound)
        alert.addAction(action)
        present(alert, animated: true, completion: nil)
        
    }
}

