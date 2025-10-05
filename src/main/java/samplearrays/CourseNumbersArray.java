package samplearrays;

public class CourseNumbersArray {
    public static void printList(int[] list) {
        for(int i = 0; i < list.length; ++i) {
            System.out.println(list[i]);
        }
        return;
    }

    public static boolean contains(int[] courseList, int course) {
        for(int i = 0; i < courseList.length; ++i) {
            if(course == courseList[i]) return true;
        }
        return false;
    }

    public static int[] addCourse(int[] registeredCourses, int newCourse) {
        int[] updatedCourses = new int[registeredCourses.length + 1];

        for(int i = 0; i < registeredCourses.length; ++i) {
            updatedCourses[i] = registeredCourses[i];
        }

        updatedCourses[registeredCourses.length] = newCourse;

        return updatedCourses;
    }  



    public static void main(String[] args) {
        int[] registeredCourses = {1010, 1020, 2080, 2140, 2150, 2160};
        int[] updatedCourseList = addCourse(registeredCourses, 1211);

        printList(updatedCourseList);

        System.out.println(contains(updatedCourseList, 9120)); // false;
        System.out.println(contains(updatedCourseList, 2080)); // true;
    }
}
