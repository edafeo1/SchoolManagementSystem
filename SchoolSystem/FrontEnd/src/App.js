import logo from './logo.svg';
import './App.css';
import StudentForm from './components/StudentForm';
import {Route, BrowserRouter as Router,Switch} from 'react-router-dom';
import StudentTable from './components/StudentTable';
import SearchStudent from './components/SearchStudent';
import AddStudent from './components/AddStudent';
import UpdateStudent from './components/UpdateStudent';
import UpdateById from './components/UpdateById';
import MUITable from './components/MUITable';

function App() {
  return (

<Router> 
<div>
  <Switch> 
  <Route exact path="/" component={StudentTable}/>
  <Route exact path="/addstudent" component={AddStudent}/>
  <Route exact path="/searchstudent" component={SearchStudent}/>
  <Route exact path="/updatestudent" component={UpdateStudent}/>
  <Route exact path="/updatebyid/:id" component={UpdateById}/>
  <Route exact path="/test" component={MUITable}/>
  </Switch>
  
  
</div>
</Router> 
  );
}

export default App;
