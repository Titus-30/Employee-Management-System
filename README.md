# 👥 Employee Management System

## 📑 Table of Contents
- [Overview](#overview)
- [Features](#features)
- [System Architecture](#system-architecture)
- [Getting Started](#getting-started)
- [Class Structure](#class-structure)
- [Salary Calculation](#salary-calculation)
- [Usage Guide](#usage-guide)
- [Input Validation](#input-validation)
- [Contributing](#contributing)
- [License](#license)

## Overview
A Java-based console application for managing employee payroll and generating pay slips. The system handles different types of employees (Managers and Developers) with specific salary calculations based on their roles and performance metrics.

## Features
### Core Functionality
- 💼 Multiple employee type support
- 💰 Automated salary calculation
- 📄 Pay slip generation
- ✅ Input validation
- 🔄 Role-specific bonus calculation

### Employee Types and Bonuses
| Role      | Base Salary | Bonus Calculation        |
|-----------|-------------|-------------------------|
| Manager   | Custom      | $200 per team member    |
| Developer | Custom      | $500 per project        |

## System Architecture
### Interface and Class Hierarchy
```
Payable (Interface)
    │
    └── Employee1 (Abstract Class)
            ├── Manager2
            └── Developer1
```

## Getting Started
### Prerequisites
- Java JDK 8 or higher
- Command line interface or IDE

### Installation
1. Clone the repository
```bash
git clone https://github.com/yourusername/employee-management-system.git
```

2. Navigate to project directory
```bash
cd employee-management-system
```

3. Compile the program
```bash
javac EmployeeManagementSystem.java
```

4. Run the application
```bash
java EmployeeManagementSystem
```

## Class Structure
### 1. Payable Interface
- `calculateSalary()`: Calculates total salary
- `getPaySlip()`: Generates formatted pay slip

### 2. Employee1 (Abstract Class)
- Core attributes:
  - name
  - employeeId
  - baseSalary
- Abstract methods implementation
- Getter methods for encapsulation

### 3. Employee Types
#### Manager2
- Additional attribute: teamSize
- Bonus: $200 × number of team members
- Custom pay slip format

#### Developer1
- Additional attribute: numberOfProjects
- Bonus: $500 × number of projects
- Custom pay slip format

## Salary Calculation
### Manager Salary Formula
```
Total Salary = Base Salary + (Team Size × $200)
```

### Developer Salary Formula
```
Total Salary = Base Salary + (Number of Projects × $500)
```

## Usage Guide
1. **Start Application**
   - Run the program
   - Select employee type (Manager/Developer)

2. **Enter Common Details**
   - Employee name
   - Employee ID
   - Base salary

3. **Enter Role-Specific Details**
   - For Managers: Team size
   - For Developers: Number of projects

4. **View Results**
   - Generated pay slip with:
     - Employee details
     - Base salary
     - Bonus calculation
     - Total salary

## Input Validation
### Implemented Validations
- Employee type must be "Manager" or "Developer"
- Employee ID must be numeric
- Base salary must be numeric
- Team size must be numeric (Managers)
- Number of projects must be numeric (Developers)

### Error Handling
- Invalid inputs prompt re-entry
- Specific error messages for each validation failure
- Loop until valid input is received

## Contributing
1. Fork the repository
2. Create feature branch
```bash
git checkout -b feature/YourFeature
```
3. Commit changes
```bash
git commit -m 'Add YourFeature'
```
4. Push to branch
```bash
git push origin feature/YourFeature
```
5. Create Pull Request

### Development Guidelines
- Follow Java naming conventions
- Maintain existing code structure
- Add appropriate error handling
- Include comments for complex logic
- Test new features thoroughly

## License
This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details.

---
💡 **Tips**
- Have all employee information ready before starting
- Note that bonuses are calculated differently for each role
- Pay slips are automatically formatted based on role

⚠️ **Note**: This is a console-based application designed for educational purposes and basic employee management simulation.
