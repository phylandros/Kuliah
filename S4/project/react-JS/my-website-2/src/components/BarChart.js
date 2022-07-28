import { Bar } from "react-chartjs-2";

const BarChart = () => {
  return (
    <>
      <Bar
        data={{
          labels: ["Jakarta", "Bekasi"],
        }}
        height={400}
        width={600}
        options={{
          maintainAspectRatio: false,
        }}
      />
    </>
  );
};

export default BarChart;
