
// import "./App.css";
// import Sidebar from "./components/Sidebar";
import Sidebar from "./components/Sidebar";
import {
	BrowserRouter as Router,
	Routes,
	Route,
} from "react-router-dom";
import { DashBoard } from "./pages/Dashboard";
import {
  Attendance,
} from "./pages/Attendance";
import Leave from "./pages/Leave";
import Salary from "./pages/Salary";
import Login from "./pages/Login";
function App() {
	return (
		<Router>
			<Sidebar />
			<Routes>
				<Route
					path="/login"
					element={<Login />}
				/>
				<Route
					path="/attendance"
					element={<Attendance />}
				/>
				<Route
					path="/leave"
					element={<Leave />}
				/>
				
				<Route
					path="/salary"
					element={<Salary />}
				/>
				
				<Route
					path="/Dashboard"
					element={<DashBoard />}
				/>
			</Routes>
		</Router>
	);
}

export default App;
