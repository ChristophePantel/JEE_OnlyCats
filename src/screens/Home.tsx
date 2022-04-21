import MainContent from '../components/main-content';
import Navbar from '../components/navbar';
import Suggestions from '../components/suggestions';

export default function Home() {
  return (
    <div className="flex min-h-screen flex-row">
      <Navbar />
      <MainContent />
      <Suggestions />
    </div>
  );
}
