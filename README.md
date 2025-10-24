# Operating Symulations Project

## About This Project
This repository contains a collection of simulations for fundamental Operating Systems (OS) concepts, designed to model, test, and analyze the performance of various algorithms related to process scheduling, disk access, memory management, and load balancing.

The project is organized into five main packages, each corresponding to a specific simulation task:

-   **`Symulacja1`**: CPU Scheduling Algorithms
-   **`Symulacja2`**: Disk Scheduling Algorithms
-   **`Symulacja3`**: Page Replacement Algorithms
-   **`Symulacja4`**: Frame Allocation Strategies
-   **`Symulacja5`**: Distributed Load Balancing

---

## Simulation Modules

### 1. CPU Scheduling Simulator (`Symulacja1`)

This simulation models and compares different CPU scheduling algorithms. The primary metric for comparison is the **average process waiting time**.

**Algorithms Implemented:**
* **FCFS (First-Come, First-Served)**
* **SJF (Shortest Job First)**
    * Non-preemptive
    * Preemptive (also known as SRTF - Shortest Remaining Time First)
* **Round Robin (RR)**
    * Includes the ability to set a custom time quantum.

The simulation runs on test sets of processes, each with a randomly generated arrival time and CPU burst length, to mimic a realistic system workload.

---

### 2. Disk Scheduling Simulator (`Symulacja2`)

This module simulates algorithms for scheduling I/O requests on a disk drive. The key performance metric is the **total head movement** (sum of block-to-block jumps) required to service all requests.

**Algorithms Implemented:**
* **FCFS (First-Come, First-Served)**
* **SSTF (Shortest Seek Time First)**
* **SCAN (Elevator Algorithm)**
* **C-SCAN (Circular SCAN)**

Additionally, the simulation explores the impact of real-time applications by incorporating:
* **EDF (Earliest Deadline First)**
* **FD-SCAN (Feasible Deadline SCAN)**

---

### 3. Page Replacement Algorithm Simulator (`Symulacja3`)

This simulation investigates various page replacement algorithms used in virtual memory systems. It generates a long string of page references (respecting the **principle of locality**) and counts the **number of page faults** for each algorithm.

The simulation is designed to be tested against different user-defined numbers of available physical frames.

**Algorithms Implemented:**
* **FIFO (First-In, First-Out)**
* **OPT (Optimal)**
* **LRU (Least Recently Used)**
* **Approximate LRU** (e.g., Second-Chance/Clock algorithm)
* **RAND (Random Replacement)**

---

### 4. Frame Allocation Strategy Simulator (`Symulacja4`)

This module builds upon the previous simulation by modeling a multi-process environment (e.g., ~10 processes). It analyzes how different **frame allocation strategies** affect the page fault rate, both globally and for individual processes.

The **LRU** algorithm is used as the underlying page replacement method within the frames allocated to each process.

**Allocation Strategies Implemented:**
* **Equal Allocation**
* **Proportional Allocation**
* **Page Fault Frequency (PFF) Control**
* **Working Set Model**

---

### 5. Distributed Load Balancing Simulator (`Symulacja5`)

This simulation models a distributed system with N (e.g., 50-100) processors. It implements and analyzes three different strategies for **load balancing** where tasks of varying requirements arrive at different frequencies.

**Strategies Implemented:**
1.  **Sender-Initiated (Probe-Limited):** When a task arrives, the processor probes up to `z` random processors. It transfers the task to the first one found with a load below threshold `p`.
2.  **Sender-Initiated (Threshold-Seeking):** If a processor's load exceeds `p`, it randomly selects other processors until it finds one with a load below `p` to transfer the task to.
3.  **Hybrid (Sender + Receiver-Initiated):** This combines Strategy 2 with a receiver-initiated component. Processors with a load below a minimum threshold `r` actively poll random processors and "steal" tasks from any found with a load above `p`.

**Performance Metrics:**
* Average load across all processors.
* Average standard deviation of the load.
* Total number of load queries and process migrations.

The simulation allows for user-configurable parameters (N, p, r, z).

---

## Usage

Each package (`Symulacja1`, `Symulacja2`, etc.) is a self-contained simulation. To run a simulation, compile and execute the main class within the desired package. The program should output its resulting performance metrics.
