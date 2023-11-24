import { Link } from "react-router-dom/cjs/react-router-dom.min";
import RegistrationForm from "./RegistrationForm";
const RegisteredList = ({ data }) => {
  return (
    <div className="container">
      <h5>List of Students</h5>
      <div className="card">
        {data.map((user) => (
          <div className="blog-preview" key={user.studentId}>
            <div class="card-header mt-3">
              <h4>
                Student:
                {user.student?.regNo +
                  "  " +
                  user.student?.firstName +
                  "  " +
                  user.student?.lastName}
              </h4>
            </div>
            <div class="card-body">
              <h6 class="card-title">
                <p>
                  Registered date: {user.registeredDate}
                  <p>Status</p>
                  <i>{user.registration_status}</i>
                </p>
                <p>Semester: </p>
                <i>{user.semester?.name}</i>
              </h6>
              {/* <p className="card-text">{user.student.}</p> */}
              <p className="card-text">Date of Birth :</p>
              {user.student?.dateOfBirth}
              <h5>Course List</h5>
              <select class="form-control form-control-sm">
                {user.courseList.map((course) => (
                  <option>
                    {course.courseDef?.code + " " + course.courseDef?.name}
                  </option>
                ))}
              </select>
              <div className="row justify-content-between">
                <Link to={`/courses/${user.studentId}`}>
                  <div className="col-4">
                    <button type="button" class="btn btn-lg btn-primary">
                      Add courses
                    </button>
                  </div>
                </Link>

                <div class="col-4">
                  <Link to="/students/delete">
                    <button type="button" class="btn btn-secondary btn-lg">
                      Delete registration
                    </button>
                  </Link>
                </div>
              </div>
            </div>
          </div>
        ))}
      </div>
      <h6>Create a new student</h6>
      <Link to="/students/addStudent">click here</Link>
    </div>
  );
};

export default RegisteredList;
