/*
 * (C) Copyright 2005 Davide Brugali, Marco Torchiano
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA
 * 02111-1307  USA
 */
package multiformat;

import java.util.Stack;

/**
 * The multiformat calculator
 */
public class Calculator {
  private Rational operand_0 = new Rational();
  private Rational operand_1 = new Rational();
  private Stack<Rational> rationalStack = new Stack<Rational>();
  
  // The current format of the calculator
  private Format format = new FixedPointFormat();
  // The current numberbase of the calculator
  private Base base = new DecimalBase();

  public void addOperand(String newOperand) throws FormatException {
      rationalStack.push(format.parse(newOperand, base));
  }

  public void add(){
	  if(rationalStack.size()>=2){
	  	Rational returnRational = rationalStack.firstElement();
	  	rationalStack.remove(0);
		for(Rational operand: rationalStack){
			returnRational = returnRational.plus(operand);
		}
		rationalStack.clear();
	    rationalStack.push(returnRational);
  	}else{
  		System.out.println("Error: not enough operands are entered");
  	}
  }
  public void subtract() {
    if(rationalStack.size()>=2){
	  	Rational returnRational = rationalStack.firstElement();
	  	rationalStack.remove(0);
		for(Rational operand: rationalStack){
			returnRational = returnRational.minus(operand);
		}
		rationalStack.clear();
	    rationalStack.push(returnRational);
  	}else{
  		System.out.println("Error: not enough operands are entered");
  	}
  }
  public void multiply() {
    if(rationalStack.size()>=2){
	  	Rational returnRational = rationalStack.firstElement();
	  	rationalStack.remove(0);
		for(Rational operand: rationalStack){
			returnRational = returnRational.mul(operand);
		}
		rationalStack.clear();
	    rationalStack.push(returnRational);
  	}else{
  		System.out.println("Error: no operands entered");
  	}
  }
  public void divide() {
    if(rationalStack.size()>=2){
	  	Rational returnRational = rationalStack.firstElement();
	  	rationalStack.remove(0);
		for(Rational operand: rationalStack){
			returnRational = returnRational.div(operand);
		}
		rationalStack.clear();
	    rationalStack.push(returnRational);
  	}else{
  		System.out.println("Error: not enough operands are entered");
  	}
  }
  public void delete() {
    rationalStack.pop();
  }

  public String firstOperand(){
    return format.toString(operand_1,base);
  }
  public String secondOperand(){
    return format.toString(operand_0,base);
  }
  /**
   * Gets a string of all operands that are stored in the stack seperated by a comma.
   * @return A String of all operands seperated by a comma.
   */
  public String getOperandsString(){
	  String returnString = "";
	  for(Rational operand: rationalStack){
		  returnString = returnString+format.toString(operand,base)+", ";
	  }
	  if(rationalStack.size()>0){
		  returnString = returnString.substring(0,returnString.length()-2);
	  }
	  return returnString;
  }

  public void setBase(Base newBase){
    base = newBase;
  }
  public Base getBase(){
    return base;
  }
  public void setFormat(Format newFormat){
    format = newFormat;
  }
  public Format getFormat(){
    return format;
  }
}