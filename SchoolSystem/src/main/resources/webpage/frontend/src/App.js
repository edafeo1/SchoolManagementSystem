import logo from './logo.svg';
import './App.css';
import StudentForm from './components/StudentForm';
import StudentTable from './components/StudentTable';
import UpdateStudentForm from './components/UpdateStudentForm';

function App() {
  return (
    <div className="App">

      <StudentTable/>
      <StudentForm/>
      <UpdateStudentForm/>
      
    </div>
  );
}

export default App;
