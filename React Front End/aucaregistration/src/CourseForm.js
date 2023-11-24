import { useState } from "react";

const CourseForm = () => {
  const [code, setCode] = useState("");
  const [name, setName] = useState("");
  const [description, setDescription] = useState("");
  const [loading, setLoading] = useState(false);

  const formHandle = (e) => {
    e.preventDefault();
    const course = { code, name, description };
    setLoading(true);
    setTimeout(
      () => {
        fetch("http://127.0.0.1:8080/courseDef/createCourseDefinition", {
          method: "POST",
          headers: {
            "Content-Type": "application/json",
          },
          body: JSON.stringify(course),
        }).then((res) => {
          setLoading(false);
        });
      },

      2000
    );
  };

  return (
    <div className="container mt-5">
      <h4>Add new Courses</h4>
      <form onSubmit={formHandle}>
        <div className="row">
          <div className="col">
            <input
              type="text"
              className="form-control"
              placeholder="Course code"
              value={code}
              onChange={(e) => setCode(e.target.value)}
            />
          </div>
          <div className="col">
            <input
              type="text"
              className="form-control"
              placeholder="course Name"
              value={name}
              onChange={(e) => setName(e.target.value)}
            />
          </div>
          <div className="col">
            <input
              type="text"
              className="form-control"
              placeholder="Course Description"
              value={description}
              onChange={(e) => setDescription(e.target.value)}
            />
          </div>
          {!loading && (
            <button type="submit" class="btn btn-secondary ">
              Add Course
            </button>
          )}
          {loading && <button class="btn btn-secondary ">saving ....</button>}
        </div>
      </form>
    </div>
  );
};

export default CourseForm;
