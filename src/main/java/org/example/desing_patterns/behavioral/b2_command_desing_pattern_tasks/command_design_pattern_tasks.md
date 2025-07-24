Great! The **Command Design Pattern** is very useful when you want to encapsulate a request as an object, allowing you to parameterize clients with different requests, queue or log requests, and support undoable operations.

---

### ✅ **Practice Task: Smart Home Remote Control**

**Scenario:**
You're building a simple **Smart Home Remote Control** system. The remote control can be programmed to control different devices like **Light**, **Fan**, and **AC**. Each device should support basic operations like **ON** and **OFF**. You should be able to:

* Execute commands (turn ON/OFF devices)
* Support undo operation
* Support macro command (execute multiple commands at once)

---

### 🧩 Requirements:

1. Create a `Command` interface with an `execute()` and `undo()` method.
2. Implement concrete commands for:

    * `LightOnCommand`, `LightOffCommand`
    * `FanOnCommand`, `FanOffCommand`
    * `ACOnCommand`, `ACOffCommand`
3. Implement receiver classes:

    * `Light`, `Fan`, and `AC` with `on()` and `off()` methods.
4. Create an `Invoker` class `RemoteControl` with:

    * A method to set commands to slots (buttons)
    * A method to press a button (execute the command)
    * A method to press undo
5. Bonus:

    * Add `MacroCommand` which takes a list of commands and runs them all together.

---

### 🧪 Example Usage:

```java
RemoteControl remote = new RemoteControl();

Light livingRoomLight = new Light();
Fan ceilingFan = new Fan();
AC bedroomAC = new AC();

Command lightOn = new LightOnCommand(livingRoomLight);
Command fanOn = new FanOnCommand(ceilingFan);
Command acOn = new ACOnCommand(bedroomAC);

// Set commands to slots
remote.setCommand(0, lightOn);
remote.setCommand(1, fanOn);
remote.setCommand(2, acOn);

// Execute commands
remote.pressButton(0); // Light ON
remote.pressButton(1); // Fan ON
remote.undo();         // Undo Fan ON (turns Fan OFF)

// Macro example
Command[] partyMode = { lightOn, fanOn, acOn };
MacroCommand partyCommand = new MacroCommand(partyMode);
remote.setCommand(3, partyCommand);
remote.pressButton(3); // All devices ON
```

---

Awesome! If you've already built the **RemoteControl** example, you're on the right track. Let's level it up with **real-world use cases** where the **Command Pattern** is very helpful—especially those resembling backend systems or actual software workflows.

---

### ✅ **Practice Task 2: Restaurant Order Management System**

#### 🧾 Scenario:

You're building a backend system for a restaurant. Waiters take orders from customers (like *Pasta*, *Burger*, *Coffee*) and send them to the kitchen.

Each order is a **command**, which the **waiter (invoker)** queues and sends to the **kitchen (receiver)** to be executed. Also, customers may cancel their orders (support `undo()`).

---

#### 🔧 Core Concepts:

* **Command Interface**: `OrderCommand` with `execute()` and `undo()`
* **Concrete Commands**: `PastaOrderCommand`, `BurgerOrderCommand`, `CoffeeOrderCommand`
* **Receiver**: `Kitchen`, which has methods like `cookPasta()`, `cancelPasta()`, etc.
* **Invoker**: `Waiter`, which takes and stores commands, sends them to the kitchen, and allows undo
* **Client**: Main function where commands are created and passed

---

#### 🧪 Example:

```java
Waiter waiter = new Waiter();
Kitchen kitchen = new Kitchen();

OrderCommand pasta = new PastaOrderCommand(kitchen);
OrderCommand burger = new BurgerOrderCommand(kitchen);

waiter.takeOrder(pasta);
waiter.takeOrder(burger);

waiter.placeOrders();  // Kitchen starts cooking Pasta and Burger

waiter.undoLastOrder();  // Kitchen cancels Burger
```

---

### ✅ **Practice Task 3: Git Command System (Version Control)**

#### 💻 Scenario:

You're building a basic **Git Command Tool**. Users can:

* `commit` changes
* `push` to remote
* `pull` latest changes
* `undo` last command

Each action is a command, and the tool should log command history for undo.

---

#### Components:

* `GitCommand` interface: `execute()`, `undo()`
* Commands: `CommitCommand`, `PushCommand`, `PullCommand`
* Receiver: `GitRepository` with methods like `commit()`, `push()`, `pull()`, `revertLastCommit()`
* Invoker: `GitClient` to handle user input and track command history

---

### ✅ **Practice Task 4: Job Scheduler System**

#### 🧾 Scenario:

You're building a **Job Scheduler**, which schedules and runs jobs like:

* `SendEmailJob`
* `DataBackupJob`
* `GenerateReportJob`

You can add, execute, or cancel (undo) jobs.

* Each job is a `Command`
* `Scheduler` (Invoker) stores and runs jobs
* `JobExecutor` (Receiver) does the actual work

---

Would you like to implement **one** of these next? I can provide a full skeleton or help you build it step by step.
