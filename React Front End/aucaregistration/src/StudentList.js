import { useState } from "react";
import { Link } from "react-router-dom/cjs/react-router-dom.min";

const StudentList = ({ data }) => {
  const [id, setId] = useState("");
  const [loading, setLoading] = useState(false);
  const deleteStudent = () => {
    setLoading(true);
    setTimeout(() => {
      fetch("http://127.0.0.1:8080/student/" + id, {
        method: "DELETE",
        headers: {
          "Content-Type": "application/json",
        },
      })
        .then((res) => {
          console.log(res);
          setLoading(false);
        })
        .catch((err) => {
          console.log(err);
        });
    }, 2000);
  };

  return (
    <div className="container">
      <h5>List of Students</h5>
      <div className="card">
        {data.map((user) => (
          <div className="blog-preview" key={user.regNo}>
            <div class="card-header mt-3">
              <h3>{user.firstName + " " + user.lastName}</h3>
            </div>
            <div class="card-body">
              <h5 class="card-title">
                {user.firstName}
                {user.lastName}
              </h5>
              <p className="card-text">{user.regNo}</p>
              <p className="card-text">{user.dateOfBirth}</p>

              <div className="row justify-content-between">
                <div className="col-4">
                  <button type="button" class="btn btn-lg btn-primary">
                    Register {user.firstName}
                  </button>
                </div>
                <div class="col-4">
                  {!loading && (
                    <button
                      type="button"
                      class="btn btn-secondary btn-lg"
                      onMouseOver={() => setId(user.regNo)}
                      onClick={deleteStudent}
                    >
                      Delete {user.firstName}
                    </button>
                  )}
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

export default StudentList;
