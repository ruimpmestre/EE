#!/bin/sh
# --------------------------------------------------------------------------------------------------------------------
# Project: Exercise 1
# --------------------------------------------------------------------------------------------------------------------
# Company: Equal Experts.
# --------------------------------------------------------------------------------------------------------------------
# 
# This file contains the script for Fizz Buzz 
# 
# -------------------------------------------------------------------------------------------------------------------- 
# $Id$
# --------------------------------------------------------------------------------------------------------------------
#

# define the reference folder pointing to the installation directory
export EXERCISE_HOME=.

#clean
rm -rf $EXERCISE_HOME/bin/*

#compile
javac -d $EXERCISE_HOME/bin -cp $EXERCISE_HOME/lib/ src/com/ee/fizzbuzz/*.java

#execute
java -cp .:$EXERCISE_HOME/bin:$EXERCISE_HOME/lib/* com.ee.fizzbuzz.FizzBuzz