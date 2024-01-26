# State Machine Library in Java
 # Table of Contents
Overview
Features
Getting Started
Clone the Repository
Set Up the Project
Explore the Code
Use Example State Machines
PlantUML Diagrams
Contribution
License

# Overview
This Java library provides a flexible and maintainable framework for creating and executing finite state machines. The library follows a three-layered architecture, promoting separation of concerns and adhering to a no-inheritance policy. It allows developers to build custom state machines with dynamic transition side effects.

# Features
Three-Layer Architecture:

Layer 1: State Machine Core
Interfaces and default implementations for states, transitions, and state machines.
Layer 2: Side Effects
Interfaces and implementations for transition side effects, allowing dynamic runtime assignments.
Layer 3: State Machine Builders
Interfaces and implementations for building different types of state machines using components from Layers 1 and 2.
Transition Side Effects:

Generalized side effects for state transitions.
Dynamically assign arbitrary code (side effects) to transitions at runtime.
No Inheritance:

Strict adherence to the no-inheritance policy.
Composition-based design for better flexibility and maintainability.

# Getting Started
# 1. Clone the Repository
git clone https://github.com/your-username/state-machine-library-java.git
cd state-machine-library-java
# 2. Set Up the Project
Ensure you have JDK 11 installed.
Compile and run the project using your preferred Java build tool.
# 3. Explore the Code
The src directory contains the three-layered architecture.
Review interfaces and classes for states, transitions, side effects, and state machine builders.
# 4. Use Example State Machines
Check out the provided state machines:
SumOfDigitsEquals3: Implements a state machine for summing digits equal to 3.
FindAbcAndPrintThings: Implements a state machine for finding the substring "Abc" with customizable logging side effects.
Modify or create your own state machines.
# 5. PlantUML Diagrams
Refer to the design.puml file for PlantUML diagrams illustrating the design and relationships between different layers.

# License
This State Machine Library in Java is open-source and available under the MIT License.
