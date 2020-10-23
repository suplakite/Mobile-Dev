//
//  FaceView.swift
//
//  Created by Student on 23.10.2020.
//  Copyright © 2020 pl.polsl. All rights reserved.
//

import UIKit

class FaceView: UIView {
    
    var r:CGFloat = 0.12
    var g:CGFloat = 0.64
    var b:CGFloat = 1
    var mouth: CGFloat = 50
    
    // Only override drawRect: if you perform custom drawing.
    // An empty implementation adversely affects performance during animation.
    override func draw(_ rect: CGRect) {
        // Drawing code
        let bounds:CGRect = self.bounds
        
        var midPoint=CGPoint() // center of our bounds in our coordinate system
        midPoint.x = bounds.origin.x + bounds.size.width/2
        midPoint.y = bounds.origin.y + bounds.size.height/2
        
        
        var point1=CGPoint()
        point1.x = midPoint.x
        point1.y = midPoint.y
        
        var point2=CGPoint()
        point2.x = midPoint.x - 40
        point2.y = midPoint.y - 40
        
        var point3=CGPoint()
        point3.x = midPoint.x + 40
        point3.y = midPoint.y - 40
        
        var point4=CGPoint()
        point4.x = midPoint.x - 55
        point4.y = midPoint.y + 45
        
        var point5=CGPoint()
        point5.x = midPoint.x + 55
        point5.y = midPoint.y + 45
        
        var point6=CGPoint()
        point6.x = midPoint.x
        point6.y = midPoint.y + mouth

        let path:UIBezierPath=UIBezierPath()
        path.addArc(withCenter: point1, radius: 110, startAngle: 0, endAngle: CGFloat(2 * Double.pi), clockwise: true)
        path.lineWidth=10
        let color = UIColor(red: self.r, green: self.g, blue: self.b, alpha: alpha)
        color.setFill()
        path.stroke()
        path.fill()
        
        
        let path1:UIBezierPath=UIBezierPath()
        path1.addArc(withCenter: point2, radius: 15, startAngle: 0, endAngle: CGFloat(2 * Double.pi), clockwise: true)
        UIColor.white.setFill()
        path1.lineWidth=10
        path1.stroke()
        path1.fill()
        
        let path2:UIBezierPath=UIBezierPath()
        path2.addArc(withCenter: point3, radius: 15, startAngle: 0, endAngle: CGFloat(2 * Double.pi), clockwise: true)
        UIColor.white.setFill()
        path2.lineWidth=10
        path2.stroke()
        path2.fill()
        
        let path3:UIBezierPath=UIBezierPath()
        path3.move(to:point4)
        path3.lineWidth=5
        path3.addQuadCurve(to: point5, controlPoint: point6)
        path3.stroke()
    }
    
    
}
