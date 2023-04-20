import microbit
import random
import math

class BreakOutOfALoop(Exception): pass
class ContinueLoop(Exception): pass

timer1 = microbit.running_time()

def run():
    global timer1
    microbit.display.scroll("Press A")
    while True:
        if microbit.button_a.is_pressed() == True:
            break
    microbit.display.scroll("Press B")
    while True:
        if microbit.button_b.is_pressed() == True:
            break
    microbit.display.scroll("Press Pin 0 Capacitive")
    while True:
        if microbit.pin0.is_touched() == True:
            break
    microbit.display.scroll("Press Pin 1 Capacative")
    while True:
        if microbit.pin1.is_touched() == True:
            break
    microbit.display.scroll("Press Pin 2 Capacitive")
    while True:
        if microbit.pin2.is_touched() == True:
            break
    microbit.pin0.set_touch_mode(microbit.pin0.RESISTIVE)
    microbit.display.scroll("Press Pin 0 Resistive")
    while True:
        if microbit.pin0.is_touched() == True:
            break
    microbit.display.scroll("Press Pin 1 Resistive")
    while True:
        if microbit.pin1.is_touched() == True:
            break
    microbit.display.scroll("Press Pin 2 Resistive")
    while True:
        if microbit.pin2.is_touched() == True:
            break
    microbit.display.scroll("Press Logo")
    while True:
        if microbit.pin_logo.is_touched() == True:
            break
    microbit.display.scroll("Finished!!")

def main():
    try:
        run()
    except Exception as e:
        raise

if __name__ == "__main__":
    main()