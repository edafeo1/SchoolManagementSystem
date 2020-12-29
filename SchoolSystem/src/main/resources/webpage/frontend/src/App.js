import logo from './logo.svg';
import './App.css';
import StudentForm from './components/StudentForm';
import {Route, BrowserRouter as Router,Switch} from 'react-router-dom';
import StudentTable from './components/StudentTable';
import SearchStudent from './components/SearchStudent';
import AddStudent from './components/AddStudent';
import UpdateStudent from './components/UpdateStudent';

function App() {
  return (

<Router> 
<div>
  <Switch> 
  <Route exact path="/" component={StudentTable}/>
  <Route exact path="/addstudent" component={AddStudent}/>
  <Route exact path="/searchstudent" component={SearchStudent}/>
  <Route exact path="/updatestudent" component={UpdateStudent}/>
  </Switch>
  
  
</div>
</Router> 
  );
}

export default App;
