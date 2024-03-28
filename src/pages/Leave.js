import React, { useState } from 'react';
import styled from "styled-components";
import './Leave.css'
import Button from 'react-bootstrap/Button';
import { FcInfo } from "react-icons/fc";

const Leave = () => {

  const [leaveType, setLeaveType] = useState('');
  const [fromDate, setFromDate] = useState('');
  const [toDate, setToDate] = useState('');
  const [applyingTo, setApplyingTo] = useState('');

  const handleLeaveTypeSelect = (selectedType) => {
    setLeaveType(selectedType);
  };

  const handleDateSelect = (selectedDate) => {
    if (leaveType === 'From Date') {
      setFromDate(selectedDate);
    } else {
      setToDate(selectedDate);
    }
  };

  const handleApplyingToSelect = (selectedName) => {
    setApplyingTo(selectedName);
  };

  return (
	<div className='container' style={{ }}>
    <div className=''>
      <div className='d-flex justify-content-between'>
      <h1>Apply Leave</h1>
      <div>
      <button className='me-2 btn btn-outline border border-primary'>Cancel</button>
        <button className='btn btn-primary'>Submit</button>
      </div>
      </div>
      <hr />
      <FcInfo /><p>Leave is earned by an employee and granted by the employer to take time off work. The employee is free to avail this leave in accordance with the company policy.</p>
      <form className='form'>
        <label htmlFor="leaveType">Leave Type:</label>
        <select name="leaveType" id="leaveType" onChange={(e) => handleLeaveTypeSelect(e.target.value)}>
          <option value="">Select type</option>
          <option value="maternity">Maternity Leave</option>
          <option value="sick">Sick Leave</option>
          <option value="earned">Earned Leave</option>
          <option value="compensatory">Compensatory Off</option>
          <option value="workFromHome">Work From Home</option>
        </select>
        <br />
        
          
        <label htmlFor="fromDate">From Date:</label>
        <input type="date" name="fromDate" id="fromDate" onChange={(e) => handleDateSelect(e.target.value)} />
        
        <label htmlFor="toDate">To Date:</label>
        <input type="date" name="toDate" id="toDate" onChange={(e) => handleDateSelect(e.target.value)} />
        
        <label htmlFor="applyingTo">Applying To:</label>
        <select name="applyingTo" id="applyingTo" onChange={(e) => handleApplyingToSelect(e.target.value)}>
          <option value="">Select</option>
          <option value="Sourav">Sourav</option>
		  <option value="Soumen">Soumen</option>
		  <option value="Thaanesh">Thaanesh</option>
		  <option value="Vijay">Vijay</option>
        
        </select>
        <br />
        
        <hr />
      </form>
    </div>
	</div>
  );
};

export default Leave;

