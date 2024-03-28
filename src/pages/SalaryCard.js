
import React from 'react';

const SalaryCard = ({ salary }) => {
  return (
    <div className="salary-card">
      <h2>{salary.employeeName}</h2>
      <p><strong>Employee ID:</strong> {salary.employeeId}</p>
      <p><strong>Position:</strong> {salary.position}</p>
      <p><strong>Salary:</strong> {salary.amount}</p>
      
    </div>
  );
}

export default SalaryCard;
