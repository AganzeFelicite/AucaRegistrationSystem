import CourseForm from "./CourseForm";
import useFetch from "./useFetch";
import { Link } from "react-router-dom/cjs/react-router-dom.min";
const CourseList = ({ flag }) => {
  const url = "http://127.0.0.1:8080/courseDef/all";
  const { data, isPending, error } = useFetch(url);
  return (
    <div className="container">
      <p>Available Courses</p>
      {data &&
        data.map((course) => (
          <div className="blog-preview">
            <h2>
              {course.code + " "} {course.name}
            </h2>
            <p>{course.description}</p>
            <p>Click to add A course</p>
            {flag && (
              <button type="button" class="btn btn-lg btn-primary">
                Enroll in Course
              </button>
            )}
            {!flag && (
              <button type="button" class="btn btn-lg btn-secondary">
                Delete course
              </button>
            )}
          </div>
        ))}
    </div>
  );
};

export default CourseList;
