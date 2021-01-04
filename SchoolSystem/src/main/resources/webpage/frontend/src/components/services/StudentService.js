import axios from 'axios';

const StudentUrl = 'http://localhost:8220/students';

class StudentService  {
    
    getStudents(){
        return axios.get(StudentUrl);
    }

    postStudent(student){
        return axios.post(StudentUrl, student); 
    }

    getStudentById(studentId){
        return axios.get(StudentUrl + '/' + studentId); 
    }

    updateStudentById(studentId, Student){
        return axios.put(StudentUrl + '/' + studentId, Student); 
    }

    deleteStudentById(studentId){
        return axios.delete(StudentUrl + '/' + studentId); 
    }
}

export default new StudentService();
