import { Link } from "react-router-dom/cjs/react-router-dom.min";

const SemesterList = ({ data }) => {
  return (
    <div className="container">
      <p>Available Semesters</p>
      {data &&
        data.map((semester) => (
          <div className="blog-preview">
            <p>{semester.semId}</p>
            <h2>{semester.name}</h2>
            <p>Start Date: {semester.startDate} </p>
            <p>End Date: {semester.endDate} </p>

            {true && (
              <Link to={`/addCourse/${semester.semId}`}>
                <button type="button" class="btn btn-lg btn-primary">
                  Add Course
                </button>
              </Link>
            )}
            {/* {flag && (
              <button type="button" class="btn btn-lg btn-secondary">
                Delete course
              </button>
            )} */}
          </div>
        ))}
    </div>
  );
};

export default SemesterList;
