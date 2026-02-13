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

### Environmental, Societal, Safety, and Economic Considerations

<!-- Explain how your engineering design took into account environmental, societal, economic and other constraints into consideration. It may include how your design has positive contributions to the environment and society? What type of economic decisions you made? How did you make sure that the design is reliable and safe to use? -->

### Test Cases and results

<!-- What test suits did you design to test your prototype? How did you execute the test cases to test the prototype? -->

### Limitations

<!-- Every product has some limitations, and so is the case with your design product. Highlight some of the limitations of your solution here. -->

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

<!-- - Use the IEEE reference style.
- Do not put any reference if it is not cited in the text. -->

# Appendix

<!-- If you want to provide an additional information, use this appendix. -->
