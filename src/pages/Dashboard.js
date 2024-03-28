// import React from "react";

// export const DashBoard = () => {
// 	return (

// 		<div >
// 			<div className="row">
// 				<div className="col-lg-4">
// 				<div className="p-3 d-flex justify-content-around mt-3">

// 				<div className="px-3 pt-2 p-3 ms-5 border shadow-sm w-50 ">
// 					<div className="text-center pb-1">
// 						<h4>Today</h4>
// 					</div>
// 					<hr />
// 					<div className="">
// 						<button className="btn btn-primary">My Attendance</button>
// 					</div>
// 				</div>
// 				</div>
// 				</div>
// 				<div className="col-lg-8">
// 				<div className="p-3 d-flex justify-content-around mt-3">

// 			<div className="px-3 pt-2 p-3 border shadow-sm w-25">
// 				<div className="text-center pb-1">
// 					<h4>Total Employees</h4>
// 				</div>
// 				<hr />
// 				<div className="">
// 					<h5>Total: </h5>
// 				</div>
// 			</div>
// 			<div className="px-3 pt-2 p-3 border shadow-sm w-25">
// 				<div className="text-center pb-1">
// 					<h4>Employee</h4>
// 				</div>
// 				<hr />
// 				<div className="">
// 					<h5>Total: </h5>
// 				</div>
// 			</div>
// 			<div className="px-3 pt-2 p-3 border shadow-sm w-25">
// 				<div className="text-center pb-1">
// 					<h4>Salary</h4>
// 				</div>
// 				<hr />
// 				<div className="">
// 					<h5>Total: </h5>
// 				</div>

// 			</div>
// 		</div>
// 				</div>
// 			</div>
// 		</div>

// 	);
// };

// import React from 'react';
// import './Dashboard.css';

// export const DashBoard = () => {
//   return (
// 	<>

// 	<div className="chart">

// 	</div>
// 	</>

//   );
// };
import React from "react";
import { Link } from "react-router-dom";
import "./Dashboard.css";

export const DashBoard = () => {
  const attendanceData = [
    {
      id: "-",
      employee: "-",
      role: "-",
      department: "-",
      date: "-",
      status: "-",
      checkIn: "-",
      checkOut: "-",
      hours: "-",
    },
  ];

  return (
    <>
      <div className="row new-dashboard">
      <div className="col-lg-4">
      <div className="dashboard-section-1 ms-25">
            <p>Today</p>
            <p>Date: </p>
            <Link
              to="/attendance"
              style={{
                backgroundColor: "#1890ff",
                color: "white",
                padding: "8px 16px",
                borderRadius: "4px",
                textDecoration: "none",
              }}
            >
              View Attendance
            </Link>
          </div>
        </div>
        <div className="dashboard col-lg-8 system">
          <div className="dashboard-section">
            <h2>Employee Summary</h2>
            <p>Total Employees: 100</p>
            <p>Active Employees: 85</p>
            <p>On Leave: 10</p>
          </div>

          <div className="dashboard-section">
            <h2>Attendance Summary</h2>
            <p>Total Working Days: 20</p>
            <p>Present Days: 18</p>
            <p>Absent Days: 2</p>
          </div>

          <div className="dashboard-section">
            <h2>Leave Requests</h2>
            <ul>
              <li>John Doe - Vacation (Pending)</li>
              <li>Jane Smith - Sick Leave (Approved)</li>
            </ul>
          </div>

          <div className="dashboard-section">
            <h2>Recent Activities</h2>
            <ul>
              <li>New employee registered - John Smith</li>
              <li>Leave request approved - Jane Doe</li>
            </ul>
          </div>

          <div className="dashboard-section">
            <h2>Upcoming Events</h2>
            <p>Team Meeting - July 10th, 2023</p>
            <p>Training Session - July 15th, 2023</p>
          </div>

          <div className="dashboard-section">
            <h2>Quick Links</h2>
            <ul>
              <li>
                <a href="/attendance">Attendance Tracking</a>
              </li>
              <li>
                <a href="/leave">Leave Management</a>
              </li>
              <li>
                <a href="/salary">Salary Info</a>
              </li>
            </ul>
          </div>
        </div>
        
      </div>

      <div
        style={{
          padding: "24px",
          backgroundColor: "#f0f2f5",
        }}
      >
        <div
          style={{
            display: "flex",
            justifyContent: "space-between",
            alignItems: "center",
            marginBottom: "16px",
          }}
        >
          <h1 style={{ margin: 0 }}>Attendance Overview</h1>
          <div>
            <input
              style={{
                marginRight: "8px",
                padding: "8px",
                borderRadius: "4px",
                border: "1px solid #d9d9d9",
              }}
              type="text"
              placeholder="Quick Search..."
            />
            <input
              style={{
                marginRight: "8px",
                padding: "8px",
                borderRadius: "4px",
                border: "1px solid #d9d9d9",
              }}
              type="date"
            />
            <Link
              to="/attendance"
              style={{
                backgroundColor: "#1890ff",
                color: "white",
                padding: "8px 16px",
                borderRadius: "4px",
                textDecoration: "none",
              }}
            >
              View Attendance
            </Link>
          </div>
        </div>
        <table
          style={{
            width: "100%",
            borderCollapse: "collapse",
            backgroundColor: "white",
            borderRadius: "8px",
            boxShadow: "0 2px 3px rgba(0, 0, 0, 0.1)",
          }}
        >
          <thead
            style={{
              backgroundColor: "#fafafa",
            }}
          >
            <tr>
              <th
                style={{ padding: "16px", borderBottom: "1px solid #f0f0f0" }}
              >
                ID
              </th>
              <th
                style={{ padding: "16px", borderBottom: "1px solid #f0f0f0" }}
              >
                Employee
              </th>
              <th
                style={{ padding: "16px", borderBottom: "1px solid #f0f0f0" }}
              >
                Role
              </th>
              <th
                style={{ padding: "16px", borderBottom: "1px solid #f0f0f0" }}
              >
                Department
              </th>
              <th
                style={{ padding: "16px", borderBottom: "1px solid #f0f0f0" }}
              >
                Date
              </th>
              <th
                style={{ padding: "16px", borderBottom: "1px solid #f0f0f0" }}
              >
                Status
              </th>
              <th
                style={{ padding: "16px", borderBottom: "1px solid #f0f0f0" }}
              >
                Check-in
              </th>
              <th
                style={{ padding: "16px", borderBottom: "1px solid #f0f0f0" }}
              >
                Check-out
              </th>
              <th
                style={{ padding: "16px", borderBottom: "1px solid #f0f0f0" }}
              >
                Work hours
              </th>
            </tr>
          </thead>
          <tbody>
            {attendanceData.map((entry) => (
              <tr key={entry.id}>
                <td
                  style={{ padding: "16px", borderBottom: "1px solid #f0f0f0" }}
                >
                  {entry.id}
                </td>
                <td
                  style={{ padding: "16px", borderBottom: "1px solid #f0f0f0" }}
                >
                  {entry.employee}
                </td>
                <td
                  style={{ padding: "16px", borderBottom: "1px solid #f0f0f0" }}
                >
                  {entry.role}
                </td>
                <td
                  style={{ padding: "16px", borderBottom: "1px solid #f0f0f0" }}
                >
                  {entry.department}
                </td>
                <td
                  style={{ padding: "16px", borderBottom: "1px solid #f0f0f0" }}
                >
                  {entry.date}
                </td>
                <td
                  style={{ padding: "16px", borderBottom: "1px solid #f0f0f0" }}
                >
                  {entry.status}
                </td>
                <td
                  style={{ padding: "16px", borderBottom: "1px solid #f0f0f0" }}
                >
                  {entry.checkIn}
                </td>
                <td
                  style={{ padding: "16px", borderBottom: "1px solid #f0f0f0" }}
                >
                  {entry.checkOut}
                </td>
                <td
                  style={{ padding: "16px", borderBottom: "1px solid #f0f0f0" }}
                >
                  {entry.hours}
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </>
  );
};
