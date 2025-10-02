# Calculator Converter GUI

A Modern Scientific Java Application combining a powerful scientific calculator and multi-unit converter in a desktop GUI.

## Overview

**CalculatorConverterGUI** is built with Java Swing. It supports:
- Advanced arithmetic & scientific operations: sqrt, log, sin, cos, tan, factorial, exp, abs, inverse, etc.
- 20+ popular unit conversions: temperature, speed, length, mass, area, energy, pressure, time, and more.

## Features

- **Calculator Modes:** Basic & advanced operations
- **Converter Modes:** Instant unit conversion (temperature, mass, volume, etc.)
- **History Panel:** View and scroll back through all past calculations/conversions. 'View All' button for full dialog.
- **Copy Result:** Instantly copy computed result to clipboard.
- **Error Feedback:** Invalid fields highlighted, error popups for clarity.
- **Keyboard Shortcuts:**  
  - Enter: Calculate  
  - Esc: Reset all fields
- **Dark Mode:** Toggle interface with a single button.
- **Scientific Constants Picker:** Insert `π` or `e` easily.
- **Reset Button:** Clear all user inputs/outputs fast.
- **Responsive Layout:** Uses GridBagLayout for adaptability across screens.

## Requirements

- Java JDK 8+

## How to Run

1. Compile:
    ```
    javac CalculatorConverterGUI.java
    ```
2. Run:
    ```
    java CalculatorConverterGUI
    ```
3. The application window will launch. Use mode selector, input fields, buttons, and shortcuts as described above.

## Screenshots

<p align="center">
  <img src="screenshots/initial%20preview.png" width="215"/>
  <img src="screenshots/calculator%20preview.png" width="215"/>
  <img src="screenshots/converter%20preview.png" width="215"/>
</p>
<p align="center">
  <b>Initial Preview</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>Calculator Preview</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>Convertor Preview</b>
</p>

<p align="center">
  <img src="screenshots/converter%20preview%202.png" width="215"/>
  <img src="screenshots/History%20Preview.png" width="215"/>
  <img src="screenshots/Dark%20Mode%20preview.png" width="215"/>
</p>
<p align="center">
  <b>Converter Preview 2</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>History Preview</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>Dark Mode Preview</b>
</p>



## Usage Tips

- Select mode (Calculator/Converter), then choose an operation.
- Use the constants picker for advanced math.
- View calculation history on the right panel or 'View All'.
- Copy the latest result easily for use elsewhere.
- Toggle dark mode for comfort.
- Use the reset button for bulk computations.

## Technologies

- Java 8
- Java Swing GUI toolkit

## Credits

Developed by **Tanveer, Plaksha University** (Computer Science) for coursework, self-learning, and portfolio enhancement.

## License

Open for educational, personal, or demo use. Please attribute when re-using or sharing.

## Future Extensions

- Save/load history to file
- Graph plotting for functions
- Multi-language/localization support
- Persistent dark mode settings

For questions or feedback, contact: **tanveerheir68@gmail.com**
