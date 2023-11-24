import Nav from "./Nav";
import {
  BrowserRouter as Router,
  Switch,
  Route,
} from "react-router-dom/cjs/react-router-dom.min";
import Student from "./Student";
import AddStudentForm from "./AddStudentForm";
import Registration from "./Registration";
import RegistrationForm from "./RegistrationForm";
import CourseList from "./CourseList";
import CourseForm from "./CourseForm";
import Semester from "./Semester";

function App() {
  return (
    <div className="App">
      <Nav />
      <Router>
        <Switch>
          <Route path="/students" exact>
            <Student />
          </Route>
          <Route path="/students/addStudent" exact>
            <AddStudentForm />
          </Route>
          <Route path="/registration" exact>
            <RegistrationForm />
            <Registration />
          </Route>
          <Route path="/courses" exact>
            <CourseForm />
            <CourseList />
          </Route>
          <Route path="/courses/:studentId" exact>
            <CourseList flag={true} />
          </Route>
          <Route path="/semester" exact>
            <Semester />
          </Route>
        </Switch>
      </Router>
    </div>
  );
}

export default App;
