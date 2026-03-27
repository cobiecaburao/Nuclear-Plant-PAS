![UR_logo](images/ur_logo-w-1-line-tagline_horiz_full-colour_rgb.png)

ENSE 375 - Software Testing and Validation

Public Alert System

Cobie Caburao (200436566)\
Kamran Aqeel (200482882)\
Bright Ugbor (200461156)


Table of Contents

[1 Introduction](#_Toc43885122)

[2 Design Problem](#_Toc43885123)

[2.1 Problem Definition](#_Toc43885124)

[2.2 Design Requirements](#_Toc43885125)

[2.2.1 Functions](#_Toc43885126)

[2.2.2 Objectives](#_Toc43885127)

[2.2.3 Constraints](#_Toc43885128)

[3 Solution](#_Toc43885129)

[3.1 Solution 1](#_Toc43885130)

[3.2 Solution 2](#_Toc43885131)

[3.3 Final Solution](#_Toc43885132)

[3.3.1 Components](#_Toc43885133)

[3.3.2 Environmental, Societal, Safety, and Economic Considerations](#_Toc43885135)

[3.3.3 Test Cases and Results](#_Toc43885135)

[3.3.4 Limitations](#_Toc43885136)

[4 Team Work](#_Toc43885137)

[4.1 Meeting 1](#_Toc43885138)

[4.2 Meeting 2](#_Toc43885139)

[4.3 Meeting 3](#_Toc43885140)

[4.4 Meeting 4](#_Toc43885141)

[5 Project Management](#_Toc43885142)

[6 Conclusion and Future Work ](#_Toc43885143)

[7 References ](#_Toc43885144)

[8 Appendix ](#_Toc43885145)

- Proof read the text for typing and grammar mistakes.
- Follow the IEEE Bibliography style for the references by selecting "References/ Citations & Bibliography/ Style".

List of Figures

List of Tables

# Introduction <a name="_Toc43885122"></a>

<!-- - Give a brief description of the design and a summary of the relevant background information related to the topic. Give a rationale about what is needed and why.
- Give the reader an overview of what is in the next sections.
- Do not put any detailed results of your work here. -->
The Nuclear Plant Public Alert System (PAS) is a communication infrastructure designed to provide immediate digital notification to the public within a designated Emergency Planning Zone (EPZ). Widespread panic can arise due to false alarms within the PAS. This project intends to limit human error in the operation of the system during training exercises by configuring layered verification to send a live alert using conditional locking.
# Design Problem 

<!-- This section has the following two subsections: -->

## Problem Definition

<!-- Write a problem statement of the project. -->
Nuclear Plant PAS need to be secure and reliable for the public to trust and properly respond to any emergency situation. To prevent false alarms, that would put the PASs reliability into question, conditional locking will be placed onto live alerts.
## Design Requirements

<!-- This section has the following three subsections: -->

### Functions
<ul>
  <li>Send immediate digital alerts to the public within the Emergency Planning Zone (EPZ).</li>
  <li>Allow training exercises without triggerign actual public alerts.</li>
  <li>Log all alert attempts and actions fro auditing and accountability.</li>
</ul>

<!-- - Provide functions of the design project. Remember that the functions contain verbs. -->

### Objectives
<ul>
  <li>Minimize human error during the operation of PAS.</li>
  <li>Prevent false alarms to maintain public trust and credibility.</li>
  <li>Ensure alerts are sent quickly, accurately, and reliably during real emergencies.</li>
  <li>Provide safe and realistic training for PAS operators.</li>
</ul>
<!-- - Provide objectives of the design project. Remember that the objectives are specified as adjectives. -->

### Constraints
<ul>
  <li>
    <strong>Regulatory Compliance (Security and Access):</strong> Only authorized personnel can trigger live alerts, and the system must follow nuclear safety regulations.
  </li>
  <li>
    <strong>Reliability:</strong> PAS must operate continuously and accurately, even during network or power failures.
  </li>
  <li>
    <strong>Economic Factors:</strong> The system must balance security and functionality with cost-effectiveness.
  </li>
  <li>
    <strong>Societal Impacts:</strong> Alerts must avoid unnecessary panic and maintain public confidence in emergency communications.
  </li>
</ul>
<!-- - Provide constraints here. Remember that the constraints are binary (either satisfied or not). -->

# Solution

<!-- In this section, you will provide an account of some solutions your team brainstormed to implement and test the project. Some solutions might not have all the desired features, some might not satisfy the constraints, or both. These solutions come up in your mind while you brainstorm ways of implementing all the features while meeting the constraints. Towards, the end you select a solution that you think has all the features, testable and satisfies all the constraints. Remember that an engineering design is iterative in nature! -->

## Solution 1
<img width="6120" height="8160" alt="image" src="https://github.com/user-attachments/assets/55248bc8-ef95-44f3-87d0-96d0ce133f98" />

<!-- Write a brief description of your first solution and provide the reasons in terms of testing for not selecting this one. -->
- sensor class
- operator class
- supervisor class
- alert class
- log class
- systemHealth class

Solution 1 did not provide sufficient testable attributes to support boundary value, decision table and state transition testing. The decision logic for alert triggering was directly rooted in the dashboard without separation of monitoring or any validation layers, and there was no defined equivalence classes for input validation and system states. That's why solution 1 was not selected for final design.

## Solution 2
<img width="3000" height="4000" alt="image" src="https://github.com/user-attachments/assets/dd15d9be-c0f8-4a57-8c42-8294e7bbcbbb" />

<!-- This is an improved solution but might not be the final solution that you select. Give a brief description of this solution here. Again focus on its testing attributes. -->
### Specification-based Testing
- Boundary Value Aanalysis: temperature sensor, radiation sensor, pressure sensor, flow sensor, level sensor, vibration sensor
- Equivalence Class Test: arming sequence code, Shutdown idk
- Decision Table Test:
  Condition Stubs: lockdown active, shutdown active, system health, manual override
  Action Stubs: Test mode, Live mode
- State Transition Test: Finite State Machine
- Use Case Test: 

## Final Solution

<!-- This is the final solution. Explain why it is better than other solutions (focus more on testing). You may use a table for comparison purposes. After providing the reason for selecting this solution, detail it below. -->

### Components

<!-- What components you used in the solution? What is the main purpose of using individual component? What testing method did you employ for each component? Provide a block diagram (with a numbered caption, such as Fig. 1) representing the connectivity and interaction between all the components. -->
Temperature Sensor Module
This module accepts manually entered temperature readings and passes them to the data processing unit. Its purpose is to monitor thermal conditions and detect values that fall outside safe operating ranges. Boundary value analysis was applied by testing values at and around the defined temperature thresholds to verify correct system behaviour at the edges of each range. Equivalence class testing was used to confirm that values within the same class — normal, warning, and critical — produced consistent results throughout.

Pressure Sensor Module
This module receives manually entered atmospheric or structural pressure readings. It is responsible for detecting pressure anomalies that may signal a hazardous condition. The same boundary value analysis and equivalence class testing approach was applied, with inputs selected from the boundaries and interiors of each pressure equivalence class to validate correct classification and processing.

Radiation Sensor Module
This module handles manually entered ionizing radiation level data. Given the safety-critical nature of radiation monitoring, accurate classification of input values is essential. Boundary value analysis was used to test values immediately below, at, and above radiation thresholds. Equivalence class testing confirmed that all values within a given class triggered the same system response.

Seismometer Module
This module accepts manually entered ground motion or vibration intensity readings. Its role is to detect seismic activity and escalate the system state accordingly. Boundary value analysis and equivalence class testing were applied in the same manner as the other sensor modules, targeting the boundaries between seismic severity classes.

Data Processing Unit
This is the central component of the system. It receives input from all four sensor modules, validates the data, and routes it to both the display interface and the state management engine. Decision table testing was applied to verify that combinations of simultaneous sensor inputs were handled correctly and routed to the appropriate downstream components without interference.

State Management Engine
This component evaluates incoming sensor readings against predefined thresholds and determines the overall system state. State transition testing was used to verify that the system correctly moved between states — such as Normal, Warning, and Critical — in response to sensor inputs, and that all valid and invalid transitions behaved as expected.

Display Interface
This component renders the current sensor readings and overall system state to the user through the Java application window. It was tested by verifying that the displayed values updated correctly after each manual input and that state changes were immediately and accurately reflected in the UI.

Alert Notification System
This component is triggered by the state management engine when a sensor reading exceeds a defined threshold. It produces an on-screen alert to notify the user of the hazardous condition. Decision table testing was used to confirm that the correct alert was generated for each combination of sensor states, and that no alerts were incorrectly raised or suppressed.

### Environmental, Societal, Safety, and Economic Considerations

<!-- Explain how your engineering design took into account environmental, societal, economic and other constraints into consideration. It may include how your design has positive contributions to the environment and society? What type of economic decisions you made? How did you make sure that the design is reliable and safe to use? -->

### Test Cases and results

<!-- What test suits did you design to test your prototype? How did you execute the test cases to test the prototype? -->
**1. Master Input Module Thresholds**
| Module | Normal | Warning/Monitor | Critical/Emergency |
| --- | --- | --- | --- |
| Temperature | 260-310 °C | 311-320 °C | > 320 °C | 
| Pressure | 9.5-11.05 MPa | 9.09.49 / 11.06-11.50 MPa | <9.0/> 11.50 MPa | 
| Radiation | <1mSv | 1-99.9 mSv | >= 100 mSv |
| Seismic | No Event (0) | Event Detected (1) | DBE Exceeded (2) |

**2. Temperature Module - Boundary Value Analysis (BVA)**
| Case | Input(°C) | Expected Result | Reason |
| --- | --- | --- | --- |
| T1 | 19 | Invalid | Below ambient/sensor floor | 
| T2 | 264 | Invalid | Below minimum power heat | 
| T3 | 265 | Normal | Lower bound of operating window |
| T4 | 288 | Normal | Mid range of operating window |
| T5 | 310 | Normal | Upper bound of operating window |
| T6 | 311 | Warning | Immediate high-temp alert |
| T7 | 320 | Warning | Margin-to-trip limit |
| T8 | 321 | Critical | Reactor Trip (Safety System) |

**3. Pressure Module - Boundary Value Analysis (BVA)**
| Case | Input(MPa) | Expected Result | Reason |
| --- | --- | --- | --- |
| P1 | 8.99 | Critical | Low Pressure Trip (LOCA concern | 
| P2 | 9.49 | Warning| Just below Minimum operating pressure |
| P3 | 9.50 | Normal| Minimum operating pressure | 
| P4 | 11.05 | Normal | Maximum operating pressure |
| P5 | 11.06 | Warning | High pressure deviation |
| P6 | 11.51 | Critical | High Pressure Trip (Overpressure) |

**4. Radiation Module - Boundary Value Analysis (BVA)**
| Case | Input(mSv) | Expected Result | Reason |
| --- | --- | --- | --- |
| R1 | 0.9 | Normal | Within public annaul limit | 
| R2 | 1.0 | Warning| Exceeds public limit (Class B) | 
| R3 | 49.9 | Warning | Below NEW* limit |
| R4 | 50.0 | Warning | Hits NEW* annual limit |
| R5 | 99.9 | Warning | Margin to Emergency |
| R6 | 100.0 | Critical | Emergency Action Level |
| R7 | 1000.0 | Critical | Acute Health Effect Threshold |

**5. Seismometer Module - Boundary Value Analysis (BVA)**
**Testing Method**: Discrete state testing based on Canadian Design Basis Earthquake (DBE) logic.
| Class | Input Level | Expected Result | Reason |
| --- | --- | --- | --- |
| Normal | 0 | Normal | Background noise / No event | 
| Warning | 1 | Warning| Event detected (Operating Basis) | 
| Critical | 2 | Critical | DBE Exceeded (Safe Shutdown) |

**6. Data Processing Unit (DPU): Decision Table**
**Testing Method**: Decision Table Testing verifies that the "Highest Severity Wins" logic is correctly implemented
| Rule | Temperature State | Pressure State | Radiation State | Seismic State | DPU System Output |
| --- | --- | --- | --- | --- | --- |
| D1 | Normal | Normal | Normal | Normal | Normal |   
| D2 | Warning | Normal| Normal | Normal | Warning |   
| D3 | Normal | Warning | Normal | Normal | Warning |  
| D4 | Normal | Normal | Critical | Normal | Critical |  
| D5 | Normal | Normal | Normal | Normal | Critical |  
| D6 | Warning | Critical | Normal | Normal | Critical |  
| D7 | Invalid | Any | Any | Any | System Error |

**7. State Management Engine: Transistion Logic**
**Testing Method**: State Transistion Testing will verify movement between the states and will ensure the "Latch" requirement.
| Current State | Condition (input Change) | Next State | Transistion Type |
| --- | --- | --- | --- |
| Normal | At least one warning | Warning | Automatic |   
| Warning | All return to normal | Normal | Automatic |   
| Warning | At least one critical | Critical | Automatic(Emergency) | 
| Critical | All return to normal | Critical | Latched (Needs Reset) | 
| Critical | Manual Reset + All Normal | Normal | Manual Override |

**8. Display Interface: Expected Output Table**
**Testing Method**: Functional testing of the Java UI to ensure synchronization with the DPU.
| Input Condition | UI Component | Expected Result |
| --- | --- | --- |
| Valid Entry (e.g., 300 °C) | Value Field | Displays "300.0 °C"|   
| Overall State: Normal | Status Label  | Text: "Normal" |   
| Overall State: Warning | Status Label  | Text: "Warning" | 
| Overall State: Critical | Status Label | Text: "Critical" | 
| invalid Entry (e.g., "ABC") | Error Message | Popup: "Invalid Numerica Input" | 

**9. Alert Notification System: Decision Table**
| System State | User Override | Alert Output | UI Colour Code |
| --- | --- | --- | --- |
| Normal | off | No Alert | Green |   
| Warning | off | Warning Popup | Yellow |   
| Critical | off | Critical Popup | Red | 
| Any | on | Override Active | Blue / Purple | 

### Limitations

There are a few important limitations to the Public ALert System(PAS) that are worth mentioning, mostly due to the fact that this is a simplified prototype rather than a fully operational system.

One of the biggest limitations is that the system uses manually entered sensor values instead of real hardware input. This means things like sensor noise, communication delays, or hardware failures weren't really considered in the design, even though these would definitely come up in a real nuclear monitoring environment.

The threshold values for temperature, pressure, radiation, and seismic activity were also kept pretty basic. They were based on publicly available Canadian nuclear information and adjusted to make testing easier. In reality, nuclear power plants use much more complex safety limits that aren't publicly available, so the actual decision logic used in practice goes well beyond what was implemented here.

Another thing to note is that the system only looks at four environmental variables. Real nuclear monitoring systems track hundreds of parameters at once such as, coolant flow, reactor power levels, equipment health, and etc. So us limiting it to four definitely simplifies things, even if it makes testing more manageable. 

The seismic part of the system is also pretty simplified. Rather than using engineering measurements like peak ground acceleration, the system just uses a few discrete input levels to represent seismic activity. It's enough to show how the state transistions work, but it's not how seismic analysis would actually be done.

The prototype also doesn't include any redundancy or fault-tolerance, which real safety-critical systems would definitely have. Normally, these systems use multiple independent sensors and voting logic to avoid false readings. So, this design solution just assumes all the inputs are correct.

Lastly, the system doesn't account for real-time performance issues like alert delays, network failures, or integration with external emergency systems, all of which would matter a lot in an actual deployment.

Overall, despite all these limitions that we have, this solution successfully manages to demonstrate the core concepts of state based decision logic, sensor classification, and alert generation using inputs that are simplified but reasonable enough for the purposes of this project.

# Team Work

<!-- Since this is a group project, you must have a fair distribution of tasks among yourselves. To this end, you must hold meetings to discuss the distribution of tasks and to keep a track of the project progress. -->

## Meeting 1

Time: Month Date, Year, hour: minutes am/pm to hour: minutes am/pm

Agenda: Distribution of Project Tasks

| Team Member | Previous Task | Completion State | Next Task |
| --- | --- | --- | --- |
| Team member 1 | N/A | N/A | Task 1 |
| Team member 2 | N/A | N/A | Task 2 |
| Team member 3 | N/A | N/A | Task 3 |

## Meeting 2

Time: Month Date, Year, hour: minutes am/pm to hour: minutes am/pm

Agenda: Review of Individual Progress

| Team Member | Previous Task | Completion State | Next Task |
| --- | --- | --- | --- |
| Team member 1 | N/A | N/A | Task 1 |
| Team member 2 | N/A | N/A | Task 2 |
| Team member 3 | N/A | N/A | Task 3 |

## Meeting 3

Time: Month Date, Year, hour: minutes am/pm to hour: minutes am/pm

Agenda: N/A

| Team Member | Previous Task | Completion State | Next Task |
| --- | --- | --- | --- |
| Team member 1 | N/A | N/A | Task 1 |
| Team member 2 | N/A | N/A | Task 2 |
| Team member 3 | N/A | N/A | Task 3 |

## Meeting 4

Time: Month Date, Year, hour: minutes am/pm to hour: minutes am/pm

Agenda: N/A

| Team Member | Previous Task | Completion State | Next Task |
| --- | --- | --- | --- |
| Team member 1 | N/A | N/A | Task 1 |
| Team member 2 | N/A | N/A | Task 2 |
| Team member 3 | N/A | N/A | Task 3 |

# Project Management

<!-- Provide a Gantt chart showing the progress of your work here. Mention all the tasks along with their predecessors. Provide the slack time of each task and identify the critical path. -->

# Conclusion and Future Work

<!-- - A summary of what you achieved. Mention all the design functions and objectives that you achieved while satisfying testing requirements?
- While keeping the limitations of your solution, provide recommendations for future design improvements. -->

# References
[1] W. J. Garland, Ed., The Essential CANDU: A Textbook on the CANDU Nuclear Power Plant Technology, University Network of Excellence in Nuclear Engineering (UNENE), 2014. [Online]. Available:(https://www.nuceng.ca/refer/candu-smr/2024-HowWhyCANDUandSMRs-Ballicatters.pdf) <br>
<br>
[2] NucEng, "Primary heat transport system chemistry control," CanTeach Library, Ref. 20032104, 2003. [Online]. Available: www.nuceng.ca <br>
<br>
[3] Canadian Nuclear Safety Commission, "REGDOC-2.5.2: Design of reactor facilities: Nuclear power plants," CNSC Regulatory Documents, 2023. [Online]. Available: www.cnsc-ccsn.gc.ca <br>
<br>
[4] NucEng, "Chapter 5: Safety systems," CANDU Safety Modules, Ref. EP714, 2009. [Online]. Available: www.nuceng.ca <br>
<br>
[5] NucEng, "CANDU 6 technical summary," Nuclear Engineering Database, 2005. [Online]. Available: www.nuceng.ca
# Appendix

<!-- If you want to provide an additional information, use this appendix. -->
